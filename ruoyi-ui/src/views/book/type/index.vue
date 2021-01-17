<template>
  <books :items="bookTypes"/>
</template>

<script>
import Books from "./Books";
import BookType from "./Book";

export default {
  name: "type",
  components: {BookType, Books},
  data()
    {
      return{
        bookTypes:[
           {
             price:145,
             title:"措施1"
           },
           {
             price:145,
             title:"措施2"
           }
         ]
      }
    },
  methods:
    {

    },
  created() {

  }
}
</script>

<style scoped lang="scss">

</style>
