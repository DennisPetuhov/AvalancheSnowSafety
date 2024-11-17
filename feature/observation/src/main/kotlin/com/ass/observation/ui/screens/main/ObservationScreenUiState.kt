@file:OptIn(ExperimentalPermissionsApi::class)

package com.ass.observation.ui.screens.main

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.android.gms.maps.model.LatLng

data class ObservationScreenUiState(
    val coordinates: LatLng?,
    val nameOfLocation: String?,
    val date: String?,
    val permissionsValue: MultiplePermissionsState?
) {
    companion object {
        val empty = ObservationScreenUiState(
            coordinates = null,
            nameOfLocation = null,
            date = null,
            permissionsValue = null
        )
    }
}