// babel.config.js
module.exports = {
  presets: [
    '@vue/app'
  ],
  env: {
    test: {
      plugins: [
        ['istanbul', {
          useInlineSourceMaps: false
        }]
      ]
    }
  }
};