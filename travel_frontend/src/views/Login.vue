<template>
  <div class="login-page max-w-md mx-auto p-6">
    <h2 class="text-2xl mb-4">로그인</h2>
    <form @submit.prevent="onSubmit">
      <div class="mb-3">
        <label>이메일</label>
        <input v-model="email" type="email" required class="w-full p-2 border rounded" />
      </div>
      <div class="mb-3">
        <label>비밀번호</label>
        <input v-model="password" type="password" required class="w-full p-2 border rounded" />
      </div>
      <div class="flex items-center justify-between">
        <button type="submit" class="btn-primary px-4 py-2">로그인</button>
        <router-link to="/signup" class="text-sm">회원가입</router-link>
      </div>
    </form>
    <p v-if="error" class="text-red-500 mt-3">{{ error }}</p>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'

const email = ref('')
const password = ref('')
const error = ref(null)
const router = useRouter()

async function onSubmit() {
  error.value = null
  try {
    const res = await axios.post(
      'http://localhost:8080/api/auth/login',
      {
        email: email.value,
        password: password.value,
      },
      { withCredentials: true },
    ) // 쿠키/세션 사용 시 필요
    // 성공 처리: 토큰/유저 데이터 저장 및 메인으로 이동
    // 예: localStorage.setItem('accessToken', res.data.token)
    router.push('/main')
  } catch (e) {
    error.value = e.response?.data?.message || '로그인 실패'
  }
}
</script>
