/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conversores;

import DTOs.AvatarDTO;
import Entidades.Avatar;

/**
 *
 * @author skevi
 */
public class AvatarCVR {
    
    public Avatar toEntity(AvatarDTO avatarDTO){
        return new Avatar(
            avatarDTO.getImageURL()
        );
    }
    
    public AvatarDTO toDTO(Avatar avatar){
        return new AvatarDTO(
            avatar.getImageURL()
        );
    }
    
}
