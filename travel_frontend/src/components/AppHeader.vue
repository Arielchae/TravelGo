<template>
  <header class="bg-white border-b shadow-sm">
    <div class="max-w-6xl mx-auto flex items-center justify-between px-4 py-3">
      <button @click="$emit('toggleSidebar')" class="md:hidden" style="width: 30px; height: 30px">
        ☰
      </button>
      <span class="text-2xl font-extrabold text-blue-600" style="font-size: 55px">여행가자</span>
      <div>
        <img src="../assets/images/logo.png" class="h-9" style="width: 80px; height: 80px" />
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: 'AppHeader',
}
</script>
