/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.minhkien.mathutil.test.core;

import com.minhkien.mathutil.core.MathUtil;
//import junit.framework.Assert;
import org.junit.Assert;
import org.junit.Test;




/**
 *
 * @author PC
 */
public class MathUtilityTest {
        //đay là class sẽ sử dụng các ahfm của thư viện/framework JUnit
        //để kiểm thử/kiểm tra code chính - hàm tinhGiaiThua() trên
        //class core.MathUnil
        //viét code để test code chính bên kia
        
        //nhiều quy tắc đặt tên hàm kiểm thử
    //nhưng thường sẽ là nói lên mục đích của các case/tình huống kiểm thử
    //tình huống xài hàm theo kiểu thành công và thất bại!!!!
    
    //hàm dưới đây là tình huống test hàm chạy thành công, trả về ngon
    //ta sẽ xài hàm kiểu well - đưa 5!, 6! hok chơi đưa -5!, 10!
    
    //@Test JUnit sẽ phối hợp với JVm để chạy hàm này
    //@Test phía hậu trường chính là public static void main()
    //có nhiều @Test ứng vơi nhiều case khác nhau để kiểm thử hàm tính giai thừa
        @Test
        public void testGetFactorialGivenRightArgmentReturnsWell() {
            int n = 0; //test thử tình huống tử tế đầu vào, màu phải chạy đúng
            long expected = 1;//gọi hàm cần test bên core/app chính/code chính
            long actual = MathUtil.getFactorial(n);
            
            //so sánh dùng expected vs. actual dùng xanh xanh đỏ đỏ, framework
            Assert.assertEquals(expected, actual);
            //hàm giúp so sánh 2 giá trị nào đó có giống nhau ko
            //nếu giống nhau -> thay màu xanh đèn đường - đường thông, code ngon
            //                  ít nhất cho case đang test
            //nếu KO GIỐNG NHAU -> thấy màu đỏ đèn đường
            //                      hàm ý expected và actual ko giống nhau
            
            //gộp thêm vài case thành công//dưa đầu vào ngon !!! hàm phải tính ngon
            Assert.assertEquals(1, MathUtil.getFactorial(1));
            Assert.assertEquals(2, MathUtil.getFactorial(2));
            Assert.assertEquals(6, MathUtil.getFactorial(3));
            Assert.assertEquals(24, MathUtil.getFactorial(4));
            Assert.assertEquals(120, MathUtil.getFactorial(5));
            Assert.assertEquals(720, MathUtil.getFactorial(6));
        }
        
        //hàm getF ta thiết kế có 2 tình huống xử lí
        //1. đưa data tử tế trong [0..20] -> tính đúng n! - done
        //2. đưa data cà chớn, âm, > 20; THIẾT KẾ CỦA HÀM LÀ NÉM RA NGOẠI LỆ
        //TAO KÌ VỌNG NGOẠI LỆ XUẤT HIỆN KHI N < 0 || N > 20
        //rất mong ngoại lện xuát hiện với n cà chớn này
        
        //nếu hàm nhận vào n < 0 hoặc n > 20 và hàm ném ra ngoại lệ
        //HÀM CHẠY ĐÚNG THIẾT KẾ
        
        //nếu hàm nhận n < 0 hoặc n > 20 và hàm éo ném ra ngoại lệ
        //sure, HÀM CHẠY SAI THIẾT KẾ, SAI KÌ VỌNG, MÀU ĐỎ
        
        //Test case: 
        //input: -5
        //expectedL IllegalArumentException xuất hiện
        //tình huống bất thường, ngoại lệ, ngoài dự tính, dự liệu
        //là những thứ ko thể đo lường so sánh theo kiẻu calue
        //mà chỉ có thể đo lường - cách chúng có xuất hiện hay ko?
        //assertEquals() ko dùng để so sánh 2 ngoại lệ
        //      equals() là bằng nhau hay ko trên value
          
        
        //MẦU ĐỎ ĐÓ EM, DO HÀM ĐÚNG LÀ CÓ NÉM NGOẠI LỆ THẬT SỰ
        //              NHƯNG KO PHẢI NGOẠI LỆ NHƯ KÌ VỌNG - THỰC SỰ KÌ VỌNG SAI
        //              KO PHẢI HÀM NÉM SAO
//        @Test(expected = NumberFormatException.class)
//        public void testGetFactorialGivenWrongArgmentThrowsException() {
//            MathUtil.getFactorial(-5);//hàm @Test chạy, hay hàm getF() chayj
//                                      //sẽ ném về ngoại lệ NumberFormat
//        }
        
        @Test(expected = IllegalArgumentException.class)
        public void testGetFactorialGivenWrongArgmentThrowsException() {
            MathUtil.getFactorial(-5);//hàm @Test chạy, hay hàm getF() chayj
                                      //sẽ ném về ngoại lệ NumberFormat
        }
        
        //cách khác bắt ngoại lệ xuất hiện, viết tự nhiên hơn
        //xài lambda 
        //Test case: hàm sẽ về ngoại lệ nếu nhận vào 21
        //tui cần thấy màu xanh khi chơi với 21
        
        @Test
        public void testGetFactorialGivenWrongArgmentThrowsException_LambdaVesion() {
            
            Assert.assertThrows(IllegalArgumentException.class,
                    () -> MathUtil.getFactorial(-5)
            );
                    
            //MathUtil.getFactorial(-5);//hàm @Test chạy, hay hàm getF() chayj
                                      //sẽ ném về ngoại lệ NumberFormat
        }
        
        
        //Bắt ngoại lệ, xem hàm có ném về ngoại lệ hay ko khi n cà chớn
        //có ném, tức là hàm chạy đúng thiết kế -> xanh
        @Test
        public void testGetFactorialGivenWrongArgmentThrowsException_TryCatch() {
            
            //chủ động kiểm soát ngoại lệ
            try {
                MathUtil.getFactorial(-5);
            } catch (Exception e) {
                //bắt try-catch là JUnit sẽ ra xanh do đã chủ động kiểm soát ngoại lệ
                //nhưng ko chắc ngoại lệ mình cần có xuất hiện hay ko??
                //có đoạn code kiểm soát đúng ngoại lệ IllegalArgumentException xh
                Assert.assertEquals("Invalid argument. N must between 0..20", 
                                        e.getMessage());
            }
        }
}
