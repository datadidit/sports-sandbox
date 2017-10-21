import Vue from 'vue'
import Router from 'vue-router'
import Dashboard from '@/components/Dashboard'
import Settings from '@/components/settings/Settings'
import Report from '@/components/report/Report'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Dashboard',
      component: Dashboard,
      redirect: 'report',
      children: [
        {
          path: 'settings',
          name: 'Settings',
          component: Settings
        },
        {
          path: 'report',
          name: 'Report',
          component: Report
        }
      ]
    }
  ]
})
