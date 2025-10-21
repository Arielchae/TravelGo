<template>
  <div>
    <Header />
    <Sidebar />
    <main class="p-4">
      <router-view />
    </main>
    <Footer />
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import Sidebar from '@/components/Sidebar.vue'
import Footer from '@/components/Footer.vue'

export default {
  components: { Header, Sidebar, Footer },
}
</script>

<style>
/* 글로벌 스타일 필요 시 추가 */
</style>
