import { createRouter, createWebHistory } from 'vue-router'
import MainHome from '@/views/MainHome.vue'
import Login from '@/views/Login.vue'
import SignUp from '@/views/SignUp.vue'
import Notice from '@/views/Notice.vue'
import MyPage from '@/views/MyPage.vue'

const routes = [
  { path: '/', name: 'home', component: MainHome },
  { path: '/login', name: 'login', component: Login },
  { path: '/signup', name: 'signup', component: SignUp },
  { path: '/notice', name: 'notice', component: Notice },
  { path: '/mypage', name: 'mypage', component: MyPage },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

export default router
