import { expect } from 'chai'
import { shallowMount } from '@vue/test-utils'
import landing from '@/components/marketing/landing.vue'

describe('landing.vue', () => {
  it('renders h1 when passed', () => {
    const wrapper = shallowMount(landing)
    expect(wrapper.find("h1").text()).equal("Vision Election")
  })
}),

describe('landing.vue', () => {
  it('renders p when passed', () => {
    const wrapper = shallowMount(landing)
    expect(wrapper.find("p"))
  })
}),

describe('landing.vue', () => {
  it('renders a when passed', () => {
    const wrapper = shallowMount(landing)
    expect(wrapper.find("a"))
  })
})
