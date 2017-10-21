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