import { createRouter, createWebHistory } from 'vue-router'
import HomeView from './../views/HomeView.vue'
import StartView from './../views/StartView.vue'
// import StartView from './../views/StartView.vue'
import SavedQuery from './../components/SavedQuery.vue'
import CreateQuery from './../components/CreateQuery.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
      name: 'home',
      component: HomeView,
      children: [
        {
          path: 'saved',
          name: 'saved',
          component: SavedQuery
        }, {
          path: 'create',
          name: 'create',
          component: CreateQuery
        },
      ]
    },
    {
      path: '/',
      name: 'start',
      component: StartView 
    },
    // {
    //   path: '/home',
    //   name: 'login',
    //   component: HomeView, 
    //   children:[
        // {
        //   path: '/saved',
        //   name: 'saved',
        //   component: SavedQuery
        // }, {
        //   path: '/create',
        //   name: 'create',
        //   component: CreateQuery
        // },
    //   ]
    // },
    
  ]
})

export default router
