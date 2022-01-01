 /**
     *이미지 Base64로 인코딩
     */
    public static String encodeToString(String fileUrl, String type) throws IOException {
    	//결과값
        String imageString = null;
       
        Image imageStr = ImageIO.read(new File("이미지 절대경로"));
        
        //fileUrl은 realPath로 설정
        BufferedImage img = (BufferedImage) imageStr;
        //image를 버퍼화		
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //ByteArrayOutputStream선언 
        
        try {
            ImageIO.write(img, type, bos);
            //ImageIO 안에 데이터 저장
            byte[] imageBytes = bos.toByteArray();
            //img를 byte로 저장
            
            BASE64Encoder encoder = new BASE64Encoder();
            //BASE64Encoder 선언
            
            imageString = encoder.encode(imageBytes);
            //BASE64Encoder 로 인코딩하여 String으로 캐스팅
            
            bos.close();
            //OutputStream 종료
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return imageString;
    }

/**
     *이미지 Base64로 디코딩
     */
    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        //BufferedImage 선언 -> 결과값
        byte[] imageByte;
        //byte 변수 선언
        
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            //BASE64Decoder 선언
            
            imageByte = decoder.decodeBuffer(imageString);
            //Base64로 인코딩된 이미지를 다시 디코딩
            
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            //InputStream 에 ByteArrayInputStream을 넣어줌
            
            image = ImageIO.read(bis);
            //ImageIO를 이용해 InputStream에 있는 이미지를 읽는다
            
            bis.close();
            //InputStream 종료
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
