import axios from 'axios'

export const calculateQOReport = ({commit, getters}, n) => {
	var url = getters.baseURL+'/topsalaries?n='+n;

	commit('loading', true)
	axios.get(url)
	.then(function(response){
		commit('updateQOReport', response.data)
		commit('generateChart')
		commit('loading', false)
	})
	.catch(function(error){
		console.log('ERROR!!!!!!')
		console.log(error)
		commit('loading', false)
	})
}

export const setBaseURL = ({commit}, value) => commit('setBaseURL', value)
export const setTopNSalaries = ({commit}, value) => commit('setTopNSalaries', value)
export const setPayroll = ({commit}, value) => commit('setPayroll', value)
export const setOffers = ({commit}, value) => commit('setOffers', value)
export const generateChart = ({commit}) => commit('generateChart')