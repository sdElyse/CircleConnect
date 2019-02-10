package com.elyseswoverland.circleconnect.ui.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elyseswoverland.circleconnect.R
import com.elyseswoverland.circleconnect.dagger.Dagger
import com.elyseswoverland.circleconnect.models.MessageResponse
import com.elyseswoverland.circleconnect.network.CircleConnectApiManager
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MessagesFragment : Fragment() {

    @Inject lateinit var circleConnectApiManager: CircleConnectApiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Dagger.getInstance().component().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_messages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        circleConnectApiManager.customerMessages
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetMessagesSuccess, this::onGetMessagesFailure)
    }

    private fun onGetMessagesSuccess(response: MessageResponse) {

    }

    private fun onGetMessagesFailure(throwable: Throwable) {

    }
}