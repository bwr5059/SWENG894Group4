module.exports = {
    runtimeCompiler: true,

    chainWebpack: config => {
      if (process.env.NODE_ENV !== "production") {
        config.module
          .rule("istanbul")
          .test(/\.(js|vue)$/)
          .enforce("post")
          .include.add("apollo-server")
          .add("src")
          .end()
          .use("istanbul-instrumenter-loader")
          .loader("istanbul-instrumenter-loader")
          .options({ esModules: true })
          .end();
      }
  }
}