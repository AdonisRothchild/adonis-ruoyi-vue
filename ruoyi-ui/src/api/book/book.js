import request from '@/utils/request'

// 查询缓存详细
export function getBookTypes() {
  return request({
    url: '/book/type',
    method: 'get'
  })
}
