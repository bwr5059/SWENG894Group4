import { expect } from 'chai'
import { Mount } from '@vue/test-utils'
import master from '@/components/layouts/master.vue'

describe('master.vue', () => {
    it('renders the navbar', () => {
      const wrapper = Mount(master)
      expect(wrapper.created).toBe('function')
    })})
