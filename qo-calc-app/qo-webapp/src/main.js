// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Vuetify from 'vuetify'
import App from './App'
import router from './router'
import store from './store'

//Styling from Vuetify
import 'vuetify/dist/vuetify.min.css' // Ensure you are using css-loader
//import 'vuetify/src/stylus/main.styl'

Vue.config.productionTip = false

Vue.use(Vuetify)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
