<template>
  <aside
    class="fixed left-0 top-0 w-64 h-full bg-gray-100 shadow-md transform -translate-x-full md:translate-x-0 transition-transform"
  >
    <nav class="p-4">
      <ul>
        <li class="mb-2"><router-link to="/">Home</router-link></li>
        <li class="mb-2"><router-link to="/notice">공지사항</router-link></li>
        <li class="mb-2"><router-link to="/signup">회원가입</router-link></li>
        <li class="mb-2"><router-link to="/mypage">MyPage</router-link></li>
      </ul>
    </nav>
  </aside>
</template>

<script>
export default {}
</script>
