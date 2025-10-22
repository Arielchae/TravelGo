<template>
  <div>
    <div class="main-box">
      <h2 style="margin-bottom: 12px">로그인</h2>
      <div class="login-card">
        <div class="form-row">
          <label>이메일</label>
          <input type="text" v-model="email" placeholder="your@email.com" />
        </div>
        <div class="form-row">
          <label>비밀번호</label>
          <input type="password" v-model="password" placeholder="password" />
        </div>
        <div class="form-row">
          <button class="btn-primary" @click="doLogin">로그인</button>
        </div>
        <div style="text-align: center; margin-top: 6px">
          <router-link to="/signup" class="small-link">회원가입 하러가기</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import auth from '@/stores/auth'

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Login',
  data() {
    return { username: '', password: '', error: '' }
  },
  methods: {
    async doLogin() {
      this.error = ''
      if (!this.username || !this.password) {
        this.error = '아이디와 비밀번호를 입력하세요.'
        return
      }
      try {
        // auth.login 내부에서 api.post('/api/members/login') 호출하게 해도 되고,
        // 여기서 api 호출 후 auth 상태 업데이트 해도 됨.
        await auth.login({ username: this.username, password: this.password })
        // 로그인 성공하면 메인으로 이동
        this.$router.push('/')
      } catch (e) {
        console.error(e)
        this.error = e.response?.data?.error || e.message || '로그인 실패'
      }
    },
  },
}
</script>
