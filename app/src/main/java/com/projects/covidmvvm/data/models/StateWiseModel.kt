package com.projects.covidmvvm.data.models

data class StateWiseModel(
		val statewise: ArrayList<StatewiseItem>
)
data class StatewiseItem(
		val recovered: String,
		val deltadeaths: String,
		val deltarecovered: String,
		val active: String,
		val deltaconfirmed: String,
		val state: String,
		val statecode: String,
		val confirmed: String,
		val deaths: String,
)
