package com.pe5ha.homework

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameView = view.findViewById<TextView>(R.id.name)
        val isOnlineView = view.findViewById<TextView>(R.id.online_status)
        val positionView = view.findViewById<TextView>(R.id.position)
        val bioView = view.findViewById<TextView>(R.id.bio)
        val achievementsView = view.findViewById<TextView>(R.id.achievements)
        val phoneNumberView = view.findViewById<TextView>(R.id.phone_number)
        val emailView = view.findViewById<TextView>(R.id.email)
        val avatarView = view.findViewById<ImageView>(R.id.avatar)
        val viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.profile.observe(viewLifecycleOwner){
            nameView.text = it.name
            isOnlineView.text = if(it.isOnline) resources.getString(R.string.status_online) else it.lastOnline
            positionView.text = it.position
            bioView.text = it.bioInfo
            achievementsView.text = it.achievements
            phoneNumberView.text = it.phoneNumber
            emailView.text = it.email
            avatarView.setImageDrawable(resources.getDrawable(it.photo))
        }
        if (savedInstanceState == null)
            viewModel.profile.value = Person.getMockPerson()[1]

    }
}