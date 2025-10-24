<template>
  <div class="signup-container">
    <h2>회원가입</h2>
    <form @submit.prevent="submitSignup">
      <div>
        <label>Email</label>
        <input v-model="email" type="email" required />
      </div>
      <div>
        <label>Password</label>
        <input v-model="password" type="password" required />
      </div>
      <div>
        <label>Nickname</label>
        <input v-model="nickname" type="text" required />
      </div>
      <div>
        <label>Social Type</label>
        <select v-model="socialType">
          <option value="LOCAL">LOCAL</option>
          <option value="GOOGLE">GOOGLE</option>
          <option value="KAKAO">KAKAO</option>
        </select>
      </div>
      <button type="submit">Sign Up</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const email = ref('')
const password = ref('')
const nickname = ref('')
const socialType = ref('LOCAL')

const submitSignup = async () => {
  try {
    const res = await axios.post('/member/signup', {
      email: email.value,
      password: password.value,
      nickname: nickname.value,
      socialType: socialType.value,
    })
    console.log('signup res status:', res.status)
    console.log('signup res data:', res.data)
    if (res.data === 'success') {
      alert('회원가입 성공!')
    } else {
      alert('회원가입 실패! 이메일 중복 가능성 있음.')
    }
  } catch (err) {
    console.error(err)
    // 디버깅용 상세 출력
    console.error('Axios error:', err)
    console.error('Response data:', err.response?.data)
    console.error('Response status:', err.response?.status)
  }
}
</script>
