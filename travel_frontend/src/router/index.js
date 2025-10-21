import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/Home.vue'
import Notice from '@/views/Notice.vue'
import SignUp from '@/views/SignUp.vue'
import MyPage from '@/views/MyPage.vue'

const routes = [
  { path: '/', name: 'home', componet: Home },
  { path: '/notice', name: 'notice', component: Notice },
  { path: '/signup', name: 'signup', component: SignUp },
  { path: '/mypage', name: 'mypage', component: MyPage },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

export default router
