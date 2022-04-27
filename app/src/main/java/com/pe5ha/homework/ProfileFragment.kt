package com.pe5ha.homework

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class ProfileFragment : Fragment() {

    companion object {
        private const val PROFILE_ID = "PROFILE_ID"
        fun newInstance(id: Int) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putInt(PROFILE_ID, id)
                }
            }
    }

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
        viewModel.profile.observe(viewLifecycleOwner) {
            nameView.text = it.name
            positionView.text = it.position
            bioView.text = it.bioInfo
            achievementsView.text = it.achievements
            phoneNumberView.text = it.phoneNumber
            emailView.text = it.email
            avatarView.setImageDrawable(resources.getDrawable(it.photo))
            if (it.isOnline) {
                isOnlineView.text = resources.getString(R.string.status_online)
                isOnlineView.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_baseline_circle_24,
                    0,
                    0,
                    0
                )
            } else {
                isOnlineView.text = it.lastOnline
                isOnlineView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            }
        }
        if (savedInstanceState == null)
            viewModel.profile.value = Person.getMockPerson()[arguments?.getInt(PROFILE_ID)!!]
        val dialogButton = view.findViewById<FloatingActionButton>(R.id.floatingDialogButton)
        dialogButton.setOnClickListener {
            Snackbar.make(it, "TODO", Snackbar.LENGTH_SHORT).show()
        }
        achievementsView.setOnClickListener {
            if (achievementsView.maxLines == 2) {
                achievementsView.maxLines = 100
                achievementsView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            } else {
                achievementsView.maxLines = 2
                achievementsView.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_baseline_keyboard_arrow_right_24,
                    0
                )
            }
        }
        phoneNumberView.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" + phoneNumberView.text.toString())
            startActivity(intent)
        }
        emailView.setOnClickListener {
            Snackbar.make(it, "TODO", Snackbar.LENGTH_SHORT).show()
        }
    }

}