import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import App from '@/App'
import QOReport from '@/components/QOReport'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/hellovue',
      name: 'Hello',
      component: Hello
    },
    {
   	  path: '/hellovuetify',
   	  name: 'Vuetify',
   	  component: App
    },
    {
      path: '/',
      name: 'QOReport',
      component: QOReport
    }
  ]
})
