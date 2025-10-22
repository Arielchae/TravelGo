<template>
  <div>
    <h1 class="text-center mt-6">여행가자에 오신 것을 환영합니다!</h1>
    <LoginForm />
  </div>
</template>

<script>
import LoginForm from '@/components/LoginForm.vue'

export default {
  name: 'MainHome',
  components: { LoginForm },
}
</script>
