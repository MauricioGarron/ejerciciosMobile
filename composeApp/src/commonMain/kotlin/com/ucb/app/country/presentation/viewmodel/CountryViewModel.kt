package com.ucb.app.country.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.app.country.model.CountryModel
import com.ucb.app.country.presentation.state.CountryEffect
import com.ucb.app.country.presentation.state.CountryEvent
import com.ucb.app.country.presentation.state.CountryState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountryViewModel: ViewModel() {
    private val _state = MutableStateFlow(CountryState())
    val state = _state.asStateFlow()

    private val _effect = Channel<CountryEffect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: CountryEvent) {
        when (event) {
            CountryEvent.OnLoad -> loadCountries()
            CountryEvent.OnRefresh -> loadCountries()
        }
    }

    private fun loadCountries() {
        _state.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            delay(1000)

            val dummyCountries = listOf(
                CountryModel(
                    "Cook Islands",
                    "Avarua",
                    "Oceania",
                    15040,
                    "https://flagcdn.com/w320/ck.png"
                ),
                CountryModel(
                    "Guinea",
                    "Conakry",
                    "Africa",
                    14363931,
                    "https://flagcdn.com/w320/gn.png"
                ),
                CountryModel(
                    "Christmas Island",
                    "Flying Fish Cove",
                    "Oceania",
                    1692,
                    "https://flagcdn.com/w320/cx.png"
                ),
                CountryModel(
                    "Togo",
                    "Lomé",
                    "Africa",
                    8095498,
                    "https://flagcdn.com/w320/tg.png"
                ),
                CountryModel(
                    "Taiwan",
                    "Taipei",
                    "Asia",
                    23317031,
                    "https://flagcdn.com/w320/tw.png"
                ),
                CountryModel(
                    "Kyrgyzstan",
                    "Bishkek",
                    "Asia",
                    7281800,
                    "https://flagcdn.com/w320/kg.png"
                ),
                CountryModel(
                    "Suriname",
                    "Paramaribo",
                    "Americas",
                    616500,
                    "https://flagcdn.com/w320/sr.png"
                ),
                CountryModel(
                    "Dominican Republic",
                    "Santo Domingo",
                    "Americas",
                    10771504,
                    "https://flagcdn.com/w320/do.png"
                ),
                CountryModel(
                    "Guatemala",
                    "Guatemala City",
                    "Americas",
                    18079810,
                    "https://flagcdn.com/w320/gt.png"
                )
            )

            _state.update {
                it.copy(
                    isLoading = false,
                    countries = dummyCountries
                )
            }
        }
    }
}