<template>
  <div class="app-root">
    <AppHeader @toggleSidebar="toggleSidebar" />
    <Navbar />
    <div class="app-body">
      <div class="left-col">
        <router-view />
      </div>
    </div>
    <AppFooter />

    <!-- Sidebar drawer -->
    <div v-if="sidebarOpen" class="sidebar-overlay">
      <div class="sidebar-backdrop" @click="toggleSidebar"></div>
      <div class="sidebar-drawer">
        <button class="sidebar-close" @click="toggleSidebar">✕ 닫기</button>

        <!-- 로그인 영역 -->
        <div class="menu-list" style="margin-bottom: 10px">
          <div v-if="!authState.loggedIn" style="padding: 12px; border-bottom: 1px solid #f0f0f0">
            <div style="font-weight: 700; margin-bottom: 6px">로그인이 필요합니다.</div>
            <div class="menu-item" @click="goLogin">로그인</div>
          </div>

          <div v-else style="padding: 12px; border-bottom: 1px solid #f0f0f0">
            <div style="font-weight: 700; margin-bottom: 6px">{{ authState.nickname }}님</div>
            <div class="menu-item" @click="go('/mypage')">내정보</div>
            <div class="menu-item" @click="doLogout">로그아웃</div>
          </div>
        </div>

        <div class="menu-list">
          <div class="menu-item" @click="go('/create')">여행계획 만들기</div>
          <div class="menu-item" @click="go('/search')">관광지 검색</div>
          <div class="menu-item" @click="go('/notice')">후기 게시판</div>
          <div class="menu-item" @click="go('/mypage')">마이페이지</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import AppHeader from '@/components/AppHeader.vue'
import AppFooter from '@/components/AppFooter.vue'
import auth from '@/stores/auth'
import Navbar from '@/components/Navbar.vue'

export default {
  name: 'App',
  components: { AppHeader, Navbar, AppFooter },
  setup() {
    const router = useRouter()
    const sidebarOpen = ref(false)

    const toggleSidebar = () => {
      sidebarOpen.value = !sidebarOpen.value
    }

    const go = (path) => {
      sidebarOpen.value = false
      router.push(path)
    }

    const goLogin = () => {
      sidebarOpen.value = false
      router.push('/login')
    }

    const doLogout = () => {
      auth.logout()
      sidebarOpen.value = false
      router.push('/')
    }

    return { authState: auth.state, sidebarOpen, toggleSidebar, go, goLogin, doLogout }
  },
}
</script>
