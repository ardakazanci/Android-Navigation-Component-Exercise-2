/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.navigation

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

/**
 * Fragment used to show how to navigate to another destination
 */
class HomeFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right

            }
        }


        /**
         * Üst Menü
         *
         * Burada ki teknik action (Ok gösterimi) olmadan direkt olarak destination olarak yapmamız.
         *
         */
        val button = view.findViewById<Button>(R.id.navigate_destination_button)
        button.setOnClickListener {
            /**
             * 3 çeşit, navigasyon tetikleme sağlanabilir.
             *
             * Fragment.findNavController()
             * View.findNavController()
             * Activity.findNavController(viewId: Int)
             *
             */
            /**
             * Eğer ki Bundle aktarımı yapılacaksa bu konsept kullanılabilir.
             *
             * Navigation.createNavigateOnClickListener(R.id.flow_step_one_dest, null)
             */
            findNavController().navigate(R.id.flow_step_one_dest, null,options)
        }

        /**
         * Alt Menü
         *
         * Burada ki teknik, navigation xml üzerinden action belirleyerek yapmamız.
         */

        view.findViewById<Button>(R.id.navigate_action_button).setOnClickListener {
            //Navigation.createNavigateOnClickListener(R.id.action_home_dest_to_flow_step_one_dest,null)
            findNavController().navigate(R.id.action_home_dest_to_flow_step_one_dest, null)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }
}
