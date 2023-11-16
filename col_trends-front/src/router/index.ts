import { createRouter, createWebHistory } from 'vue-router'
import HomeView from './../views/HomeView.vue'
import QuerySavedView from './../views/QuerySavedView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/Saved',
      name: 'saved',
      component: QuerySavedView
    }

  ]
})

export default router
