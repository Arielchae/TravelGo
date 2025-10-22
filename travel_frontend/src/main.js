import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'

import './styles.css'

const app = createApp(App)

app.use(createPinia()) // Pinia 사용
app.use(router) // 라우터 등록

app.mount('#app') // 한 번만 mount
