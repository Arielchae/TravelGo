import { reactive } from 'vue'
import api from '@/services/api'

const state = reactive({
  token: localStorage.getItem('accessToken') || null,
  nickname: localStorage.getItem('nickname') || null,
  loggedIn: !!localStorage.getItem('accessToken'),
})

async function login(payload) {
  // payload: {username, password}
  // 실제 로그인 API 호출
  const res = await api.post('/api/members/login', payload)
  // 서버 응답 구조에 맞게 수정: {token, member: {nickname, ...}}
  const token = res.data.token
  const nickname = res.data.member?.nickname || res.data.nickname || null

  if (!token) throw new Error('토큰이 없습니다.')

  // 저장
  localStorage.setItem('accessToken', token)
  if (nickname) localStorage.setItem('nickname', nickname)

  state.token = token
  state.nickname = nickname
  state.loggedIn = true

  // 전역 axios 헤더 설정 (선택)
  api.defaults.headers.common['Authorization'] = `Bearer ${token}`

  return res.data
}

function logout() {
  localStorage.removeItem('accessToken')
  localStorage.removeItem('nickname')
  state.token = null
  state.nickname = null
  state.loggedIn = false
  delete api.defaults.headers.common['Authorization']
}

export default {
  state,
  login,
  logout,
}
