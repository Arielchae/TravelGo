<template>
  <div class="navbar">
    <div class="navbar-inner">
      <button class="nav-btn" @click="$router.push('/mypage')">내 여행 계획 보기</button>
      <button class="nav-btn" @click="$router.push('/create')">새 여행 계획 만들기</button>
    </div>
  </div>
</template>

<script>
// eslint-disable-next-line vue/multi-word-component-names
export default { name: 'Navbar' }
</script>
