<template>
  <transition name="slide">
    <aside v-if="open" class="fixed inset-0 z-50 flex">
      <div class="w-64 bg-white h-full shadow-lg p-4">
        <button @click="$emit('close')">닫기 X</button>
        <ul class="space-y-3">
          <li><router-link to="/create">여행계획 만들기</router-link></li>
          <li><router-link to="/notice">관광지 검색</router-link></li>
          <li><router-link to="/signup">후기 게시판</router-link></li>
          <li><router-link to="/mypage">마이페이지</router-link></li>
        </ul>
      </div>
      <div class="flex-1" @click="$emit('close')"></div>
    </aside>
  </transition>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Sidebar',
  props: { open: { type: Boolean, default: false } },
}
</script>

<style>
.slide-enter-active,
.slide-leave-active {
  transition: transform 0.25s;
}
.slide-enter-from {
  transform: translateX(-100%);
}
.slide-enter-to {
  transform: translateX(0%);
}
.slide-leave-from {
  transform: translateX(0%);
}
.slide-leave-to {
  transform: translateX(-100%);
}
</style>
