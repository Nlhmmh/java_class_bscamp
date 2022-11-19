const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies:["vuetify"] ,
  lintOnSave: true,
  devServer:{
    port:8081,
  }
})
