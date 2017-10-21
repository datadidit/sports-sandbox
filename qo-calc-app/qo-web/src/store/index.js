import Vue from 'vue'
import Vuex from 'vuex'
import * as getters from './getters'
import * as actions from './actions'
import * as mutations from './mutations'

Vue.use(Vuex)

const state = {
  report: {
    salaries: [],
    minimum: {
      formattedValue: ''
    },
    maximum: {
      formattedValue: ''
    }, 
    mean: {
      formattedValue: ''
    },
    standardDeviation: {
      formattedValue: ''
    }
  },
  appsettings: {
    baseURL: 'https://qo-app.herokuapp.com/rest/qualifyingoffer'
  },
  reportconfiguration: {
    topNSalaries: 125,
    knownPayroll: 100
  },
  loading: false
}

const store = new Vuex.Store({
	state,
	getters,
	actions,
	mutations
})

if (module.hot) {
  module.hot.accept([
    './getters',
    './actions',
    './mutations'
  ], () => {
    store.hotUpdate({
      getters: require('./getters'),
      actions: require('./actions'),
      mutations: require('./mutations')
    })
  })
}

export default store
