<template>
    <div class="time_bar">
        <div class="year_change" >
            <el-select v-model="current_year" @change="onYearChange">
                <el-option value="2019" label="2019"></el-option>
                <el-option value="2020" label="2020"></el-option>
            </el-select>
        </div>
      <div class="write_msg">
          <el-button type="primary" size="small" @click="onAddMessage" icon="el-icon-edit">写留言</el-button>
      </div>
    </div>
</template>

<script>
    export default {
        name: "time_bar",
        data:function(){
            return {
                current_year:new Date().getFullYear()
            }
        },
        methods:{
            onYearChange(year){
                this.$emit("changeYear",year);
            },
            onAddMessage(){
                this.$emit("addMessage");
            }
        },
        mounted() {
            this.onYearChange(this.current_year);
        }
    }
</script>

<style scoped lang="less">
.time_bar{
  position: absolute;
  left: 0;
  top: 0;
  width: 120px;
  bottom: 0;
  overflow-x: hidden;
  overflow-y: auto;
  background: #fff;
  box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);
  .year_change{
    padding: 10px;
  }
  .write_msg{
    text-align: center;
  }
}
</style>
