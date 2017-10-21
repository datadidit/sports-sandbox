import axios from 'axios'

export const calculateQOReport = ({commit, getters}, n) => {
	var url = getters.baseURL+'/topsalaries?n='+n;

	axios.get(url)
	.then(function(response){
		commit('updateQOReport', response.data)
	})
	.catch(function(error){
		console.log('ERROR!!!!!!')
		console.log(error)
	})
}

export const setBaseURL = ({commit}, value) => commit('setBaseURL', value)
export const setTopNSalaries = ({commit}, value) => commit('setTopNSalaries', value)