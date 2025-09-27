package com.example.lputouch.data.source

import com.example.lputouch.data.model.ProfileDetail
import com.example.lputouch.data.model.ProfileDots

object ProfileDetailsList {
    fun getProfileDetails() : List<ProfileDetail>{
        return listOf(
            ProfileDetail(
                sectionName = "Basic",
                detailList = listOf(
                    ProfileDots(
                        name = "Father's Name",
                        value = "Deshmukh Vasanta"
                    ),
                    ProfileDots(
                        name = "Mother's Name",
                        value = "Pushpa"
                    ),
                    ProfileDots(
                        name = "Permanent Address",
                        value = "Visora, Gadchiroli - 441207 - Distt: Gadchiroli - (Maharashtra) - India"
                    ),
                    ProfileDots(
                        name = "Correspondence Address",
                        value = "Visora, Gadchiroli - 441207 - Distt: Gadchiroli - (Maharashtra) - India"
                    ),
                    ProfileDots(
                        name = "Contact No.",
                        value = "9021833029"
                    ),
                    ProfileDots(
                        name = "Email",
                        value = "bharatvdeshm2005@gmail.com"
                    ),
                    ProfileDots(
                        name = "Date of Birth",
                        value = "25 May 2005"
                    ),
                    ProfileDots(
                        name = "Gender",
                        value = "Male"
                    ),

        )),
            ProfileDetail(
                sectionName = "Academic Details",
                detailList = listOf(
                    ProfileDots(
                        name = "Program",
                        value = "P132: B.Tech. (Computer Science and Engineering) (2024)"
                    ),
                    ProfileDots(
                        name = "Admission Session",
                        value = "2024-1"
                    ),
                    ProfileDots(
                        name = "Batch",
                        value = "2024"
                    ),
                    ProfileDots(
                        name = "Section",
                        value = "K24CT"
                    ),
                    ProfileDots(
                        name = "TPC",
                        value = "Not Applicable"
                    ),
                    )),
            ProfileDetail(
                sectionName = "Hostel Details",
                detailList = listOf(
                    ProfileDots(
                        name = "Hostel",
                        value = "Boys Hostel-02- A606-Bed A (Std Non-AC 4 Seater)"
                    ),
                    ProfileDots(
                        name = "Warden",
                        value = "22332::Subhash Chand (9888598705)"
                    ),
                )),
        )
    }
}