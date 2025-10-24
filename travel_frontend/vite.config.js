import { fileURLToPath, URL } from 'node:url'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue(), vueDevTools()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  server: {
    proxy: {
      // [수정된 부분]: '/auth' 경로로 시작하는 모든 요청을 백엔드 서버로 프록시 처리
      '/auth': {
        target: 'http://localhost:8888', // 백엔드 서버 주소
        changeOrigin: true,
        secure: false,
        // rewrite는 필요 없습니다. 요청 경로가 이미 백엔드와 일치하기 때문입니다.
      },
      // 기존 '/api' 경로도 백엔드 요청을 위해 남겨둡니다. (AppHeader.vue에서 '/api/auth/me'를 사용하고 있기 때문)
      '/api': {
        target: 'http://localhost:8888', // 백엔드 서버 주소
        changeOrigin: true,
        secure: false,
        rewrite: (path) => path.replace(/^\/api/, ''), // '/api'를 제거하고 요청을 보냄 (AppHeader.vue와 충돌 방지를 위해 남김)
      },
      '/member': {
        target: 'http://localhost:8888', // 백엔드 서버 주소
        changeOrigin: true,
        secure: false,
        // rewrite는 필요 없습니다. 요청 경로가 이미 백엔드와 일치하기 때문입니다.
      },
    },
  },
})
