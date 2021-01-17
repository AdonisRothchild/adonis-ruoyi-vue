<template>
  <div>
    <el-header>
      {{title}}
    </el-header>
    <span>{{price}}</span>
  </div>
</template>
<script>
export default {
  name: "BookType",
  props:
    {
      title:
        {
          type:String,
          require:true
        },
      imgUrl:
        {
          type:String,
          default:'',
        },
      price:{
        type:Number,
        default: 0
      }
    }
}
</script>

<style scoped lang="scss">

</style>
