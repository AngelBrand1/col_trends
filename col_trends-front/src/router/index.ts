import { createRouter, createWebHistory } from 'vue-router'
import HomeView from './../views/HomeView.vue'
import SavedQuery from './../components/SavedQuery.vue'
import CreateQuery from './../components/CreateQuery.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
      children:[
        {
          path: '/saved',
          name: 'saved',
          component: SavedQuery
        }, {
          path: '/create',
          name: 'create',
          component: CreateQuery
        }
      ]
    }
  ]
})

export default router
