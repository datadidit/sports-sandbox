export const updateQOReport = (state, report) => {
	state.report.salaries = report.salaries
	state.report.n = report.salaryCount
	state.report.mean = report.mean
	state.report.minimum = report.min
	state.report.maximum = report.maximum
}