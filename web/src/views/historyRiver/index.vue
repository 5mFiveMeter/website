<template>
    <div>
      <time-bar @changeYear="queryMessageByYear" @addMessage="changeAddDialogShow"></time-bar>
      <div class="right_content">
          <el-card v-for="(v,k) in message_list" :key="v.id" style="margin-bottom: 10px;">
              <div slot="header">
                  <span>{{v.nickName}}</span>
                  <span style="float: right">{{v.occurTime}}</span>
              </div>
              <div v-html="v.content"></div>
          </el-card>
      </div>
      <!--留言编辑器-->
      <el-dialog title="新增留言" :visible="showAddDialog" :close-on-click-modal="false" width="80%" :before-close="changeAddDialogShow">
          <div>
            <div style="margin-bottom: 10px;">
                <el-input v-model="new_nickname" placeholder="先取一个不超过20字昵称吧" size="small" maxlength="20"></el-input>
            </div>
            <quill-editor v-model="new_message" :options="editor_config">
            </quill-editor>
          </div>
          <div slot="footer">
              <el-button size="small" type="primary" @click="addNewMessageRquest">确定</el-button>
              <el-button size="small" plain @click="changeAddDialogShow">取消</el-button>
          </div>
      </el-dialog>
    </div>
</template>

<script>
  import timeBar from "@/components/time_bar";
  import {quillEditor} from "vue-quill-editor";
  import 'quill/dist/quill.core.css'
  import 'quill/dist/quill.snow.css'
  import 'quill/dist/quill.bubble.css'
    export default {
        name: "index",
        components:{timeBar,quillEditor},
        data:function(){
            return {
                message_list:[],
                current_year:"",
                current_size:10,
                current_page:0,
                showAddDialog:false,
                new_message:"",
                new_nickname:"",
                editor_config:{
                    modules:{
                        toolbar:[
                            ['bold'],    //加粗，斜体，下划线，删除线
                            [{ 'size': ['small', false, 'large', 'huge'] }], // 字体大小
                            [{ 'color': [] }, { 'background': [] }],     // 字体颜色，字体背景颜色
                            ['clean'],    //清除字体样式
                        ]
                    }
                }
            }
        },
        methods:{
            //查询年度留言
            queryMessageByYear(year){
                var _that = this;
                _that.current_year = year;
                _that.$http.get("/historyRiver/getByYear",{
                    params:{
                        year:year,
                        size:_that.current_size,
                        page:_that.current_page
                    }
                }).then(function(rsp){
                    if(rsp.code==666){
                        _that.message_list = rsp.data;
                        _that.current_page += 1;
                    }else {
                        _that.$message({
                            showClose:true,
                            type:"error",
                            message:rsp.msg
                        })
                    }
                })
            },
            //新增面板显示控制
            changeAddDialogShow(){
                this.showAddDialog = !this.showAddDialog;
            },
            addNewMessageRquest(){
                var _that = this;
                if(_that.new_nickname==""){
                    _that.$message({
                        showClose:true,
                        type:"warning",
                        message:"请填写昵称"
                    })
                }else if(_that.new_message==""){
                    _that.$message({
                        showClose:true,
                        type:"warning",
                        message:"请填写内容"
                    })
                }else{
                    this.$http.post("/historyRiver/addMessage",{
                        occurYear:new Date().getFullYear(),
                        nickName:_that.new_nickname,
                        content:_that.new_message
                    }).then(function(rsp){
                        if(rsp.code==666){
                            _that.changeAddDialogShow();
                            _that.new_message = "";
                            _that.queryMessageByYear(_that.current_year);
                            _that.$message({
                                showClose:true,
                                type:"success",
                                message:"新增成功,请在最新年度查看"
                            })
                        }else {
                            _that.$message({
                                showClose:true,
                                type:"error",
                                message:rsp.msg
                            })
                        }
                    })
                }
            }
        }
    }
</script>

<style scoped lang="less">
.right_content{
  position: absolute;
  left: 121px;
  top: 0;
  right: 0;
  bottom: 0;
  background: #fff;
  padding: 10px;
}
</style>
