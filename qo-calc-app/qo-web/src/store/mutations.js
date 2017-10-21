export const updateQOReport = (state, report) => {
	state.report = report
}

export const setBaseURL = (state, value) => {
	state.appsettings.baseURL = value
}

export const setTopNSalaries = (state, value) => {
	state.reportconfiguration.topNSalaries = value
}

export const loading = (state, value) => {
	state.loading = value
}

export const setOffers = (state, value) => {
	state.team.offers = parseInt(value)
}

export const setPayroll = (state, value) => {
	state.team.payroll = parseInt(value)
}

export const generateChart = (state) => {
	var offerVal = state.report.mean.value * state.team.offers
	var actualPayroll = 1000000*state.team.payroll
	state.team.percentage = (100*(offerVal/(actualPayroll+offerVal)).toFixed(2)).toFixed(0)+'%'
	state.team.chartdata.datasets[0].data = [offerVal, actualPayroll]
}
