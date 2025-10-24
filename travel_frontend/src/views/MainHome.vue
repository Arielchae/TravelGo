<template>
  <div class="flex-1 p-4">
    <p>환경합니다. {{ user?.name || 'guest' }}</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import AppHeader from '@/components/AppHeader.vue'
import Sidebar from '@/components/Sidebar.vue'
import axios from 'axios'

// 상태 변수
const user = ref(null)
const sidebarOpen = ref(false)

// mounted 시 사용자 정보 조회
onMounted(async () => {
  try {
    const res = await axios.get('/api/auth/me', { withCredentials: true })
    user.value = res.data
  } catch {
    user.value = null
  }
})
</script>
