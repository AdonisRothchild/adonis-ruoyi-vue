<template>
  <div>
    <div  v-for="item of items">
      <book-type :price="item.price" :title="item.title"/>
    </div>
  </div>
</template>

<script>
import BookType from "./Book";

export default {
  name: "Books",
  components: {BookType},
  props:
    {
      items:
        {
          type: Array,
          require: true
        }
    }
}
</script>

<style scoped>

</style>
