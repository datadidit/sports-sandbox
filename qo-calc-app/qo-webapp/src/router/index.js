import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import QOReport from '@/components/QOReport'
import QOTable from '@/components/QOTable'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/hello',
      name: 'Hello',
      component: HelloWorld
    },
    {
    	path: '/',
    	name: 'QOReport',
    	component: QOReport
    },
    {
      path: '/table',
      name: 'Qualifying Offer Table',
      component: QOTable
    }
  ]
})
