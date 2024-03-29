package grishalarin.testproject.mvp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import grishalarin.testproject.mvp.presenter.MvpPresenter;
import grishalarin.testproject.mvp.core.MvpProcessor;
import grishalarin.testproject.mvp.view.MvpView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sostavkin Grisha
 */
public class MvpDelegate {

    private static final String MVP_DELEGATE_TAG = "MVP_DELEGATE_TAG";

    private final MvpProcessor mvpProcessor;
    private final Map<String, MvpDelegate> childDelegates = new HashMap<>();
    private final Map<MvpPresenter, String> presenters = new HashMap<>();
    private final MvpView view;
    private String delegateTag;

    private KeepAliveProvider keepAliveProvider;

    public MvpDelegate(MvpProcessor mvpProcessor, MvpView view) {
        this.mvpProcessor = mvpProcessor;
        this.view = view;
    }

    public <P extends MvpPresenter> P getPresenter(@NonNull PresenterProvider<P> presenterProvider, String tag) {
        P presenter = mvpProcessor.getPresenter(presenterProvider, tag);
        presenters.put(presenter, tag);
        return presenter;
    }

    public <P extends MvpPresenter> P getPresenter(@NonNull PresenterProvider<P> presenterProvider, @NonNull Class<P> pClass) {
        String tag = delegateTag + "_" + pClass.getName();
        P presenter = mvpProcessor.getPresenter(presenterProvider, tag);
        presenters.put(presenter, tag);
        return presenter;
    }

    public void setKeepAliveProvider(KeepAliveProvider keepAliveProvider) {
        this.keepAliveProvider = keepAliveProvider;
    }

    public void init(Bundle bundle) {
        if (bundle != null) {
            delegateTag = bundle.getString(MVP_DELEGATE_TAG);
        }
        if (delegateTag == null) {
            delegateTag = generateTag();
        }
    }

    public void init(MvpDelegate parent, String id) {
        delegateTag = parent.delegateTag + "$" + id;
        parent.childDelegates.put(delegateTag, this);
    }

    public void bindView() {
        for (MvpPresenter mvpPresenter : presenters.keySet()) {
            mvpPresenter.bind(view);
        }
        for (MvpDelegate childDelegate : childDelegates.values()) {
            childDelegate.bindView();
        }
    }

    public void unbindView() {
        for (MvpDelegate childDelegate : childDelegates.values()) {
            childDelegate.unbindView();
        }
        for (MvpPresenter mvpPresenter : presenters.keySet()) {
            mvpPresenter.unbind(view);
        }
    }

    public void saveState(Bundle outState) {
        outState.putString(MVP_DELEGATE_TAG, delegateTag);
    }

    public void destroy(boolean keepAlive) {
        for (MvpDelegate childDelegate : childDelegates.values()) {
            if (keepAliveProvider == null) {
                childDelegate.destroy(keepAlive);
            } else {
                childDelegate.destroy(keepAliveProvider.keepAlive(keepAlive));
            }
        }
        for (Map.Entry<MvpPresenter, String> entry : presenters.entrySet()) {
            mvpProcessor.freePresenter(entry.getKey(), entry.getValue(), keepAlive);
        }
    }

    private String generateTag() {
        return view.toString();
    }
}
